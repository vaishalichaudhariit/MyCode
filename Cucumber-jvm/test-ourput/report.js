$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/MyCode/Cucumber-jvm/src/test/java/Features/hooks.feature");
formatter.feature({
  "line": 1,
  "name": "Free CRM app test",
  "description": "`",
  "id": "free-crm-app-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 415409,
  "status": "passed"
});
formatter.before({
  "duration": 221480,
  "status": "passed"
});
formatter.before({
  "duration": 138289,
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
  "duration": 194154886,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinition.user_fills_the_deals_form()"
});
formatter.result({
  "duration": 98315,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinition.deal_is_created()"
});
formatter.result({
  "duration": 138830,
  "status": "passed"
});
formatter.after({
  "duration": 25813707,
  "status": "passed"
});
formatter.after({
  "duration": 96155,
  "status": "passed"
});
formatter.after({
  "duration": 106418,
  "status": "passed"
});
formatter.before({
  "duration": 246868,
  "status": "passed"
});
formatter.before({
  "duration": 143151,
  "status": "passed"
});
formatter.before({
  "duration": 117223,
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
  "duration": 117762,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinition.user_fills_the_contact_form()"
});
formatter.result({
  "duration": 124244,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinition.contact_is_created()"
});
formatter.result({
  "duration": 85890,
  "status": "passed"
});
formatter.after({
  "duration": 96154,
  "status": "passed"
});
formatter.after({
  "duration": 62663,
  "status": "passed"
});
formatter.after({
  "duration": 110199,
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
  "duration": 1311051,
  "status": "passed"
});
formatter.before({
  "duration": 119383,
  "status": "passed"
});
formatter.before({
  "duration": 91292,
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
  "duration": 133968,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinition.user_fills_the_mail_form()"
});
formatter.result({
  "duration": 2868970,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinition.mail_is_created()"
});
formatter.result({
  "duration": 122084,
  "status": "passed"
});
formatter.after({
  "duration": 70765,
  "status": "passed"
});
formatter.after({
  "duration": 57801,
  "status": "passed"
});
formatter.after({
  "duration": 53479,
  "status": "passed"
});
formatter.before({
  "duration": 264154,
  "status": "passed"
});
formatter.before({
  "duration": 125866,
  "status": "passed"
});
formatter.before({
  "duration": 63202,
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
  "duration": 107499,
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
  "duration": 110199,
  "status": "passed"
});
formatter.after({
  "duration": 74546,
  "status": "passed"
});
formatter.after({
  "duration": 70765,
  "status": "passed"
});
formatter.after({
  "duration": 74007,
  "status": "passed"
});
});