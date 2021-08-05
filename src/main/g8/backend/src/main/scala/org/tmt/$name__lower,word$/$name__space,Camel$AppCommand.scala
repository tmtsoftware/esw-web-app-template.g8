package org.tmt.$name;format="lower,word"$

import caseapp.{CommandName, ExtraName, HelpMessage}

sealed trait $name;format="space,Camel"$AppCommand

object $name;format="space,Camel"$AppCommand {

  @CommandName("start")
  final case class StartCommand(
     @HelpMessage("port of the app")
     @ExtraName("p")
     port: Option[Int]
   ) extends $name;format="space,Camel"$AppCommand

}
