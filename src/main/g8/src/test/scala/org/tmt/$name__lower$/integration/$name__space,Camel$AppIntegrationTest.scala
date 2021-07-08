package org.tmt.$name;format="lower"$.integration

import akka.actor.typed.{ActorSystem, SpawnProtocol}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.Uri.Path
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.headers.{Authorization, OAuth2BearerToken}
import akka.http.scaladsl.model.ws.{Message, TextMessage, WebSocketRequest}
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.scaladsl.{Flow, Keep, Sink, Source}
import csw.aas.core.commons.AASConnection
import csw.location.api.models.Connection.HttpConnection
import csw.location.api.models._
import csw.location.api.scaladsl.LocationService
import csw.network.utils.Networks
import csw.prefix.models.Prefix
import csw.prefix.models.Subsystem.{CSW, ESW}
import csw.testkit.scaladsl.ScalaTestFrameworkTestKit
import io.bullet.borer.Json
import org.scalatest.concurrent.PatienceConfiguration.Timeout
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import org.tmt.embedded_keycloak.KeycloakData.{ApplicationUser, Client, Realm}
import org.tmt.embedded_keycloak.impl.StopHandle
import org.tmt.embedded_keycloak.utils.BearerToken
import org.tmt.embedded_keycloak.{EmbeddedKeycloak, KeycloakData, Settings}
import org.tmt.$name;format="lower"$.$name;format="space,Camel"$Wiring
import org.tmt.$name;format="lower"$.core.models.{UserInfo, $name;format="space,Camel"$Response}
import org.tmt.$name;format="lower"$.http.HttpCodecs

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext}

class $name;format="space,Camel"$AppIntegrationTest extends ScalaTestFrameworkTestKit with AnyWordSpecLike with Matchers with HttpCodecs {

  implicit val actorSystem: ActorSystem[SpawnProtocol.Command] = frameworkTestKit.actorSystem
  implicit val ec: ExecutionContext                            = actorSystem.executionContext
  override implicit val patienceConfig: PatienceConfig         = PatienceConfig(10.seconds)

  val locationService: LocationService = frameworkTestKit.frameworkWiring.locationService
  val hostname: String                 = Networks().hostname
  val keycloakPort                     = 8081
  val $name;format="lower"$AppPort                    = 8085
  val $name;format="lower"$Wiring                     = new $name;format="space,Camel"$Wiring(Some($name;format="lower"$AppPort))
  val appConnection: HttpConnection    = $name;format="lower"$Wiring.settings.httpConnection

  var appLocation: HttpLocation  = _
  var appUri: Uri                = _
  var keycloakHandle: StopHandle = _

  protected override def beforeAll(): Unit = {
    super.beforeAll()
    keycloakHandle = startAndRegisterKeycloak(keycloakPort)
    $name;format="lower"$Wiring.start(Metadata.empty).futureValue
    appLocation = locationService.resolve(appConnection, 5.seconds).futureValue.get
    appUri = Uri(appLocation.uri.toString)
  }

  protected override def afterAll(): Unit = {
    keycloakHandle.stop()
    locationService.unregister(AASConnection.value)
    $name;format="lower"$Wiring.stop().futureValue
    super.afterAll()
  }

  "$name;format="space,Camel"$Wiring" must {

    "start the $name;format="lower"$ app and register with location service" in {
      val resolvedLocation = locationService.resolve(appConnection, 5.seconds).futureValue
      resolvedLocation.get.connection should ===(appConnection)
    }

    "should call sayHello and return $name;format="lower"$Response as a result" in {
      val token = getToken("admin", "password1")()
      val userInfo = UserInfo("John", "Smith")
      val request = HttpRequest(
        HttpMethods.GET,
        uri = appUri.withPath(Path / "sayHello"),
        headers = token.map(x => Seq(Authorization(OAuth2BearerToken(x)))).getOrElse(Nil),
        entity = HttpEntity(ContentTypes.`application/json`, Json.encode(userInfo).toUtf8String.getBytes)
      )

      val response: HttpResponse = Http().singleRequest(request).futureValue
      response.status should ===(StatusCode.int2StatusCode(200))
      Unmarshal(response).to[$name;format="space,Camel"$Response].futureValue should ===($name;format="space,Camel"$Response(s"Hello user: \${userInfo.firstname} \${userInfo.lastname}!!!"))
    }

    "should call securedSayHello and return $name;format="lower"$Response as a result" in {
      val token  = getToken("admin", "password1")()
      val userInfo = UserInfo("John", "Smith")
      val request = HttpRequest(
        HttpMethods.POST,
        uri = appUri.withPath(Path / "securedSayHello"),
        headers = token.map(x => Seq(Authorization(OAuth2BearerToken(x)))).getOrElse(Nil),
        entity = HttpEntity(ContentTypes.`application/json`, Json.encode(userInfo).toUtf8String.getBytes())
      )

      val response: HttpResponse = Http().singleRequest(request).futureValue

      response.status should ===(StatusCode.int2StatusCode(200))
      Unmarshal(response).to[Option[$name;format="space,Camel"$Response]].futureValue should ===(
        Some($name;format="space,Camel"$Response(s"Hello secured user: \${userInfo.firstname} \${userInfo.lastname}!!!"))
      )
    }

    "should call locations and return 401 as a result without valid token" in {
      val userInfo = UserInfo("John", "Smith")
      val request = HttpRequest(
        HttpMethods.GET,
        uri = appUri.withPath(Path / "locations"),
        headers = Nil
      )

      val response: HttpResponse = Http().singleRequest(request).futureValue

      response.status should ===(StatusCode.int2StatusCode(401))
    }

    "should call securedSayHello and return 403 as a result without required role" in {
      val token  = getToken("nonAdmin", "password2")()
      val userInfo = UserInfo("John", "Smith")
      val request = HttpRequest(
        HttpMethods.POST,
        uri = appUri.withPath(Path / "securedSayHello"),
        headers = token.map(x => Seq(Authorization(OAuth2BearerToken(x)))).getOrElse(Nil),
        entity = HttpEntity(ContentTypes.`application/json`, Json.encode(userInfo).toUtf8String.getBytes())
      )

      val response: HttpResponse = Http().singleRequest(request).futureValue

      response.status should ===(StatusCode.int2StatusCode(403))
    }

    "should call locations and return Locations as a result" in {
      val token     = getToken("admin", "password1")()
      val aasPrefix = Prefix(CSW, "AAS")
      val appPrefix = Prefix(ESW, "$name;format="lower"$")
      val request = HttpRequest(
        HttpMethods.GET,
        uri = appUri.withPath(Path / "locations"),
        headers = token.map(x => Seq(Authorization(OAuth2BearerToken(x)))).getOrElse(Nil)
      )

      val response: HttpResponse = Http().singleRequest(request).futureValue

      response.status should ===(StatusCode.int2StatusCode(200))
      Unmarshal(response).to[List[Location]].futureValue.map(_.prefix) should ===(List(aasPrefix, appPrefix))
    }

    "should call greeter and return stream response as a result" in {
      val userInfo    = UserInfo("John", "Smith")
      val uri       = appLocation.uri
      val wsRequest = WebSocketRequest(uri = s"ws://\${uri.getHost}:\${uri.getPort}/greeter")

      val (connectionSink, connectionSource) =
        Source.asSubscriber[Message].mapMaterializedValue(Sink.fromSubscriber).preMaterialize()

      val requestSource = Source.single(TextMessage.Strict(encode(userInfo))).concat(Source.maybe) // adding userInfo request
      val flow          = Flow.fromSinkAndSourceCoupled(connectionSink, requestSource)

      Http().singleWebSocketRequest(wsRequest, flow) // send request

      // collect responses
      val (_, responsesF) = connectionSource
        .take(3) // to limit the infinite source
        .collect { case msg: TextMessage.Strict => decode$name;format="space,Camel"$Res(msg) }
        .toMat(Sink.seq)(Keep.both)
        .run()

      // assert on response
      val expectedRes = $name;format="space,Camel"$Response(s"Hello user: \${userInfo.firstname} \${userInfo.lastname}!!!")
      eventually(Timeout(1600.millis)) { // 3 msg with 500 millis interval
        val responses = responsesF.futureValue
        responses.size shouldBe 3
        responses should ===(Seq.fill(3)(expectedRes))
      }

    }
  }

  private def encode(userInfo: UserInfo) = Json.encode(userInfo).toUtf8String

  private def decode$name;format="space,Camel"$Res(msg: TextMessage.Strict) = Json.decode(msg.text.getBytes()).to[$name;format="space,Camel"$Response].value

  private def startAndRegisterKeycloak(port: Int): StopHandle = {
    val eswUserRole  = "Esw-user"
    val eswAdminRole = "Esw-admin"
    val locationServerClient =
      Client(name = "tmt-frontend-app", clientType = "public", passwordGrantEnabled = true)
    val keycloakData = KeycloakData(
      realms = Set(
        Realm(
          name = "TMT",
          users = Set(
            ApplicationUser("admin", "password1", realmRoles = Set(eswUserRole, eswAdminRole)),
            ApplicationUser("nonAdmin", "password2")
          ),
          clients = Set(locationServerClient),
          realmRoles = Set(eswUserRole, eswAdminRole)
        )
      )
    )
    val embeddedKeycloak = new EmbeddedKeycloak(keycloakData, Settings(port = port, printProcessLogs = false))
    val stopHandle       = Await.result(embeddedKeycloak.startServer(), 1.minute)
    locationService.register(HttpRegistration(AASConnection.value, keycloakPort, "auth")).futureValue
    stopHandle
  }

  private def getToken(userName: String, password: String): () => Some[String] = { () =>
    Some(
      BearerToken
        .fromServer(
          realm = "TMT",
          client = "tmt-frontend-app",
          host = hostname,
          port = keycloakPort,
          username = userName,
          password = password
        )
        .token
    )
  }

}
