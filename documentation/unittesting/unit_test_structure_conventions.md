# Unit Test Structure & Conventions

<!-- TOC -->

* [Unit Test Structure & Conventions](#unit-test-structure--conventions)
    * [Unit Test Structure](#unit-test-structure)
    * [Unit Test Conventions](#unit-test-conventions)
        * [General conventions](#general-conventions)
    * [Naming of test cases (test methods)](#naming-of-test-cases--test-methods-)
    * [Reference](#reference)

<!-- TOC -->

Looking at JUnit tests can be a bit weird at times. Often a lot of preparation work in terms of
preparing mock objects and responses is required. Even though this is very well supported by tools
like Mockito and PowerMock , the resulting test code is not always easy to read, understand and thus
maintain.

So, it is necessary to define proper structure for our unit tests.

## Unit Test Structure

We will divide your tests – into three sections for preparation, execution, and verification.

The following code snippet shows an example of this approach.

```kotlin
@Test
fun `Test - UserConfirmedToExecuteScenario - SuccessCase`() = gherkin {
        val scenario: TicketScenarioItemViewModel

        Given("Scenario to be executed") {
            scenario = generateTicketScenarioItemViewModel()
        }
        And("TicketInteractor.executeScenario - returns success") {
            whenever(mockTicketInteractor.executeScenario(any(), any()))
                .thenReturn(Completable.complete())
        }

        When("On UserConfirmedToExecuteScenario") {
            presenter.onUserConfirmedToExecuteScenario(scenario)
        }

        Then("Should send success callback") {
            verify(mockView).showExecuteScenarioProgress()
            verify(mockView).hideExecuteScenarioProgress()
            verify(mockView).sendCallbackThatScenarioExecutedSuccessfullyAndFinishTheScreen()
        }
    }
```

The purpose of the different sections should be quite obvious. But let’s have a short overview of
those nonetheless.

**Preparation -> Given**

Here objects are created that are required as return values for mocked method calls or as input
parameters to the method under test. Furthermore, the mocked method calls as such are prepared in
this section. Often this is the longest and most complicated part of a JUnit test.

**Note**: It might be a bit confusing that the Mockito statements starting with when are part of the
Given-section. But as this is related to the preparation of the test execution, this is perfectly
fine.

**Execution -> When**

This basically only calls the tested method. It can thus always very easily be seen what is tested
with a certain JUnit test. This is usually the shortest part of a test.

**Verification -> Then**

In this section, assertions on any results from the execution step are implemented. In addition, it
can be checked if certain (mocked) method calls have happened. At least those are the typical things
to check here.

## Unit Test Conventions

We have created a simple DSL to help us enforce above structure upon our tests. The base
function is `gherkin` (for setting up a test). Inside a `gherkin` block, we just use the
same `Given`/`When`/`Then`/`And` functions.

The full DSL can be found
[here](../../freshservice_app/src/test/java/com/freshservice/helpdesk/core/dsl/GherkinDsl.kt).

### General conventions

- Test file names should use the following convention:
  `{ClassUnderTest}Test.kt`.
    - For example: `TicketScenarioPresenterImplTest.kt`
- Any local variables should be placed at the top of the function with no whitespace between the
  test name and the variables. There should be one empty line between the variables and the Gherkin
  blocks.
- There are three possible sections to a test - `Given/And`, `When/And` and
  `Then/And`. Each of these sections should be surrounded by one empty line except at the end of the
  function.
- There should be no empty line between a `Given` and an `And` block.

## Naming of test cases (test methods)

Follow the below suggested naming conversion for test methods,

```kotlin
fun `Test - [Method under test] - [State under test]`()
```

## Reference

- https://martinfowler.com/bliki/GivenWhenThen.html
- https://blog.codecentric.de/en/2017/09/given-when-then-in-junit-tests/
- https://cucumber.io/docs/gherkin/reference/
- https://www.guru99.com/gherkin-test-cucumber.html




