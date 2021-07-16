package org.tmt.$name;format="lower"$

import caseapp.core.RemainingArgs
import csw.location.api.models.Metadata
import esw.http.template.wiring.ServerApp
import $name;format="space,Camel"$AppCommand.StartCommand

object $name;format="space,Camel"$App extends ServerApp[$name;format="space,Camel"$AppCommand] {
  override def appName: String    = getClass.getSimpleName.dropRight(1)

  override def run(command: $name;format="space,Camel"$AppCommand, remainingArgs: RemainingArgs): Unit =
    command match {
      case StartCommand(port) =>
        val wiring = new $name;format="space,Camel"$Wiring(port)
        start(wiring, Metadata.empty)
    }
}
