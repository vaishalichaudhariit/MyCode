$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/SeleniumWorkspace/Cucumber-jvm/src/test/java/Features/hooks.feature");
formatter.feature({
  "line": 1,
  "name": "Free CRM app test",
  "description": "`",
  "id": "free-crm-app-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 531011,
  "status": "passed"
});
formatter.before({
  "duration": 259833,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 3,
      "value": "# Hook is for pre and post condition to execute our test scenarios"
    }
  ],
  "line": 6,
  "name": "Free CRM Create deal test",
  "description": "",
  "id": "free-crm-app-test;free-crm-create-deal-test",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@First"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "user is on deal page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user fills the deals form",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "deal is created",
  "keyword": "Then "
});
formatter.match({
  "location": "HooksStepDefinition.user_is_on_deal_page()"
});
formatter.result({
  "duration": 359398439,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinition.user_fills_the_deals_form()"
});
formatter.result({
  "duration": 144232,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinition.deal_is_created()"
});
formatter.result({
  "duration": 108579,
  "status": "passed"
});
formatter.after({
  "duration": 99936,
  "status": "passed"
});
formatter.after({
  "duration": 155036,
  "status": "passed"
});
formatter.before({
  "duration": 226341,
  "status": "passed"
});
formatter.before({
  "duration": 108579,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Free CRM Create contact test",
  "description": "",
  "id": "free-crm-app-test;free-crm-create-contact-test",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@Second"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "user is on contact page",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "user fills the contact form",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "contact is created",
  "keyword": "Then "
});
formatter.match({
  "location": "HooksStepDefinition.user_is_on_contact_page()"
});
formatter.result({
  "duration": 117763,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinition.user_fills_the_contact_form()"
});
formatter.result({
  "duration": 132888,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinition.contact_is_created()"
});
formatter.result({
  "duration": 113981,
  "status": "passed"
});
formatter.after({
  "duration": 109660,
  "status": "passed"
});
formatter.after({
  "duration": 162059,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 18,
  "name": "Free CRM Create mail test",
  "description": "",
  "id": "free-crm-app-test;free-crm-create-mail-test",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 17,
      "name": "@Third"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "user is on mail page",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "user fills the mail form",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "mail is created",
  "keyword": "Then "
});
formatter.examples({
  "line": 22,
  "name": "",
  "description": "",
  "id": "free-crm-app-test;free-crm-create-mail-test;",
  "rows": [
    {
      "cells": [
        "mail1"
      ],
      "line": 23,
      "id": "free-crm-app-test;free-crm-create-mail-test;;1"
    },
    {
      "cells": [
        "mail2"
      ],
      "line": 24,
      "id": "free-crm-app-test;free-crm-create-mail-test;;2"
    },
    {
      "cells": [
        "mail3"
      ],
      "line": 25,
      "id": "free-crm-app-test;free-crm-create-mail-test;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 245248,
  "status": "passed"
});
formatter.before({
  "duration": 176104,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Free CRM Create mail test",
  "description": "",
  "id": "free-crm-app-test;free-crm-create-mail-test;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 17,
      "name": "@Third"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "user is on mail page",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "user fills the mail form",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "mail is created",
  "keyword": "Then "
});
formatter.match({
  "location": "HooksStepDefinition.user_is_on_mail_page()"
});
formatter.result({
  "duration": 151254,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinition.user_fills_the_mail_form()"
});
formatter.result({
  "duration": 131268,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinition.mail_is_created()"
});
formatter.result({
  "duration": 109659,
  "status": "passed"
});
formatter.after({
  "duration": 153956,
  "status": "passed"
});
formatter.after({
  "duration": 108579,
  "status": "passed"
});
formatter.before({
  "duration": 248489,
  "status": "passed"
});
formatter.before({
  "duration": 112901,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Free CRM Create mail test",
  "description": "",
  "id": "free-crm-app-test;free-crm-create-mail-test;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 17,
      "name": "@Third"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "user is on mail page",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "user fills the mail form",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "mail is created",
  "keyword": "Then "
});
formatter.match({
  "location": "HooksStepDefinition.user_is_on_mail_page()"
});
formatter.result({
  "duration": 108039,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinition.user_fills_the_mail_form()"
});
formatter.result({
  "duration": 89672,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinition.mail_is_created()"
});
formatter.result({
  "duration": 82650,
  "status": "passed"
});
formatter.after({
  "duration": 106419,
  "status": "passed"
});
formatter.after({
  "duration": 76708,
  "status": "passed"
});
});