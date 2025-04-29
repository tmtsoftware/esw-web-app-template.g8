package org.tmt.$name;format="lower,word"$

import caseapp.core.RemainingArgs
import csw.location.api.models.Metadata
import csw.network.utils.SocketUtils
import $name;format="space,Camel"$AppCommand.StartOptions
import caseapp.Command
import caseapp.core.help.Help
import caseapp.core.parser.Parser
import caseapp.core.app.{Command, CommandsEntryPoint}
import esw.constants.CommonTimeouts
import esw.http.template.wiring.ServerWiring
import org.tmt.$name;format="lower,word"$.impl.$name;format="space,Camel"$Wiring

import scala.concurrent.Await
import scala.util.control.NonFatal

object $name;format="space,Camel"$App extends CommandsEntryPoint {
  private val appName: String = getClass.getSimpleName.dropRight(1)
  private val appVersion: String = "0.1.0"
  override def progName: String = "$name;format="lower,word"$"

  private val StartCommand: Runner[StartOptions] = Runner[StartOptions]()
  override def commands: Seq[Command[?]] = List(StartCommand)

  private class Runner[T: {Parser, Help}] extends Command[T] {
    override def run(command: T, args: RemainingArgs): Unit = {
      command match {
        case StartOptions(port) =>
          val wiring = new $name;format="space,Camel"$Wiring(Some(port.getOrElse(SocketUtils.getFreePort)))
          start(wiring, Metadata.empty)
      }
    }

    private def start(wiring: ServerWiring, metadata: Metadata): Unit = {
      try {
        wiring.actorRuntime.startLogging(progName, appVersion)
        wiring.logger.debug(s"starting \$appName")
        val (binding, _) = Await.result(wiring.start(metadata), CommonTimeouts.Wiring)
        wiring.logger.info(s"\$appName online at http://\${binding.localAddress.getHostString}:\${binding.localAddress.getPort}/")
      }
      catch {
        case NonFatal(ex) =>
          ex.printStackTrace()
          wiring.logger.error(s"\$appName crashed")
          exit(1)
      }
    }
  }
}

