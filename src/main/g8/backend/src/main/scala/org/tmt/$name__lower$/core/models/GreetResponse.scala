package org.tmt.$name;format="lower"$.core.models

case class GreetResponse(greeting: String)
object GreetResponse {
  def apply(userInfo: UserInfo): GreetResponse = new GreetResponse(s"Hello user: \${userInfo.firstName} \${userInfo.lastName}!!!")
}
case class AdminGreetResponse(greeting: String)
object AdminGreetResponse {
  def apply(userInfo: UserInfo): AdminGreetResponse =
    new AdminGreetResponse(s"Hello admin user: \${userInfo.firstName} \${userInfo.lastName}!!!")
}