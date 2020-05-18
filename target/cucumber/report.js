$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test.feature");
formatter.feature({
  "line": 1,
  "name": "Test baidu search for selenium",
  "description": "Search for selenium on baidu",
  "id": "test-baidu-search-for-selenium",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3026822496,
  "status": "passed"
});
formatter.before({
  "duration": 50448083549,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Test Baidu search for selenium",
  "description": "",
  "id": "test-baidu-search-for-selenium;test-baidu-search-for-selenium",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@tag"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I navigate to \"baidu\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I send \"seleniumTest\" into searchbox",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I click search button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "The correct search result is returned",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "baidu",
      "offset": 15
    }
  ],
  "location": "test.i_navigate_to(String)"
});
formatter.result({
  "duration": 17025064303,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "seleniumTest",
      "offset": 8
    }
  ],
  "location": "test.i_send_into_searchbox(String)"
});
formatter.result({
  "duration": 2935827514,
  "status": "passed"
});
formatter.match({
  "location": "test.i_click_search_button()"
});
formatter.result({
  "duration": 1223595598,
  "status": "passed"
});
formatter.match({
  "location": "test.the_correct_search_result_is_returned()"
});
formatter.result({
  "duration": 5676076484,
  "status": "passed"
});
formatter.after({
  "duration": 5187912856,
  "status": "passed"
});
});