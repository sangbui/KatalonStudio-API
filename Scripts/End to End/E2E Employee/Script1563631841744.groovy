import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper


WS.sendRequest(findTestObject('EmployeeObjects/Get All', [('baseUrl') : GlobalVariable.baseUrl]))

WS.sendRequest(findTestObject('EmployeeObjects/Gey By ID', [('baseUrl') : GlobalVariable.baseUrl]))


WS.sendRequest(findTestObject('EmployeeObjects/Add Employee', [('baseUrl') : GlobalVariable.baseUrl]))

response_delete  =  WS.sendRequest(findTestObject('EmployeeObjects/Delete Employee', [('baseUrl') : GlobalVariable.baseUrl]))

JsonSlurper slurper = new JsonSlurper()
Map parsedJson = slurper.parseText(response_delete.getResponseText())
String delete_status = parsedJson.status_message

GlobalVariable.deleteResponse = delete_status


//def jsonSlurper = new JsonSlurper()
//def jsonResponse = jsonSlurper.parseText(response_delete.getResponseText())
//def delete_status_message = jsonResponse.status_message

//GlobalVariable.deleteResponse = delete_status_message

WS.sendRequest(findTestObject('EmployeeObjects/Update Employee', [('baseUrl') : GlobalVariable.baseUrl]))

