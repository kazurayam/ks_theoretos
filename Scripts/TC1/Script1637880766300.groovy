import java.nio.file.Path
import java.nio.file.Paths

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Path projectDir = Paths.get(RunConfiguration.getProjectDir())
Path html = projectDir.resolve("page.html")
URL htmlURL = html.toUri().toURL()

WebUI.openBrowser('')
WebUI.navigateToUrl(htmlURL.toExternalForm())

String expr = '''//div'''
TestObject tObj = createTestObjectWithXPath(expr)

WebUI.verifyElementPresent(tObj, 10)

WebUI.closeBrowser()

/**
 * 
 * @param xpath
 * @return
 */
TestObject createTestObjectWithXPath(String xpath) {
	TestObject tObj = new TestObject("myTestObject")
	tObj.addProperty("xpath", ConditionType.EQUALS, xpath)
	return tObj
}