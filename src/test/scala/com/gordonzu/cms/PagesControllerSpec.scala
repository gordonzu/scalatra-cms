package com.gordonzu.cms

import org.scalatra.test.specs2._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class PagesControllerSpec extends ScalatraSpec { def is =
  "GET /pages/:slug on PagesController"                 ^
    "should return status 200"                          ! pagesWork^
    "shows the word 'Bacon' in the response body"       ! containsBacon^
                                                        end

  addServlet(classOf[PagesController], "/*")

  def pagesWork = get("/pages/bacon-ipsum") {
    status must_== 200
  }  

  def containsBacon = get("/pages/bacon-ipsum") {
    body must contain("Bacon")
  }
}


