package controllers

import play.api._
import play.api.mvc._
import play.mvc.Http

class Application extends Controller {

  def index = Action {
    Ok("Hello")
  }

  def redirect = Action {
    Redirect("http://www.google.co.uk")
  }

  def dynamic(string: String) = Action {
    Ok(string)
  }

  def static = Action {
    Ok("This is a static page!")
  }

  def default(string: String) = Action {
    Ok("Value = " + string)
  }

  def set(string: String) = Action {
    Ok(string)
  }

  def optional(string: Option[String]) = Action {
    Ok("The optional string is " + string.getOrElse("not defined"))
  }

  val ok = Ok("Hello world!")
  val notFound = NotFound
  val pageNotFound = NotFound(<h1>Page not found</h1>)
  val badRequest = BadRequest("Error happened")
  val oops = InternalServerError("Oops")
  val anyStatus = Status(488)("Strange response type")

  def helper1 = Action {
    ok
  }

  def helper2 = Action {
    notFound
  }

  def helper3 = Action {
    pageNotFound
  }

  def helper4 = Action {
    badRequest
  }

  def helper5 = Action {
    oops
  }

  def helper6 = Action {
    anyStatus
  }

  def hello(name: String) = Action {
    Ok("Hello " + name)
  }

  def helloJames = Action {
    Redirect(routes.Application.hello("James"))
  }

  def todo = TODO

  def sameRoute1 = Action {
    Ok("1st route")
  }

  def sameRoute2 = Action {
    Ok("2nd route")
  }

  def createCookie = Action { implicit request: Request[AnyContent] =>
    Ok("Cookie created!").withCookies(Cookie("name", "james"))
  }

  def viewCookie = Action { implicit request: Request[AnyContent] =>
    Ok("Cookie = " + request.cookies.get("name"))
  }

  def deleteCookie = Action { implicit request: Request[AnyContent] =>
    Ok("Cookie deleted!").discardingCookies(DiscardingCookie("name"))
  }



}