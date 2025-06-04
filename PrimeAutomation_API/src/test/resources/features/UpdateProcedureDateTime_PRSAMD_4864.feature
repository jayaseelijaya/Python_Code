Feature: PRSAMD_4864- Verifying the update procedure datetime fields via PUT API.

  @MIC_PRSAMD-4864_success
  Scenario Outline: PRSAMD_4864 - Scenario's with Valid Authorization and Valid Request Body to update procedure datetime.
    Given the user enters the Base URL to update procedure datetime for surgeon portal
    When user provides a valid "<Authorization>" with "<Token>" with the Request Body from "<SheetName>" and <RowNumber> and trigger the PUT API to update procedure datetime for surgeon portal
    Then a response code is generated for update procedure date and time
    And attribute named "responseMessage" is verified in response body to update procedure date and time

    Examples: 
      | SheetName | RowNumber | Authorization | Token                   |
      | Sheet1    |         0 | Authorization | procedure_surgeon_token |
      | Sheet1    |         1 | Authorization | procedure_staff_token   |

  @MIC_PRSAMD-4864_no_data
  Scenario Outline: PRSAMD_4864- Scenario's with Valid Authorization and Invalid global id in Request Body.
    Given the user enters the Base URL to update procedure datetime for surgeon portal
    When the user gives a Valid "<Authorization>" and  "<Token>" with Invalid global id Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update procedure datetime for Surgeon Portal
    Then Response is generated status code and patient procedure details not found to update procedure datetime
    And attribute named "errorMessage" is verified in response body to update procedure date and time

    Examples: 
      | SheetName | RowNumber | Authorization | Token                   |
      | Sheet1    |         2 | Authorization | procedure_surgeon_token |
      | Sheet1    |         3 | Authorization | procedure_staff_token   |

  @MIC_PRSAMD-4864_unauthorised
  Scenario Outline: PRSAMD_4864- Scenario's with invalid Authorization and Valid Request Body.
    Given the user enters the Base URL to update procedure datetime for surgeon portal
    When the user gives a invalid "<Authorization>" and  "<Token>" with with the Request Body Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update procedure datetime for Surgeon Portal
    Then Response is generated status code with unauthorized message
    And attribute named "errorMessage" is verified in response body to update procedure date and time

    Examples: 
      | SheetName | RowNumber | Authorization | Token         |
      | Sheet1    |         4 | Authorization | invalid_token |
      | Sheet1    |         5 | Authorization | invalid_token |
