Feature: PRSAMD_1611- Verifying Grouping of Flattened Files for given batch on per patient Basis via. POST API.

  @DUU_PRSAMD-1611_success
  Scenario Outline: PRSAMD_1611- Scenario's with Valid Authorization and Request Body
    Given the base URL is entered by the user for grouping of Flattened Files
    When user enters a valid "<Authorization>" and "<Token>" with valid request body to group flattened files and trigger the POST API
    Then a 200 response is generated to group flattened files
    And an attribute "responseMessage" is verified for grouping flattened files

    Examples: 
      | Authorization | Token               |
      | Authorization | ic_admin_token      |
      | Authorization | ic_technician_token |
      | Authorization | hosp_admin_token    |
      | Authorization | surgeon_token       |
      | Authorization | staff_token         |

  @DUU_PRSAMD-1611_failure
  Scenario Outline: PRSAMD_1611- Scenario's with Valid Authorization and Blank or already grouped batchId
    Given the base URL is entered by the user for grouping of Flattened Files
    When user enters a valid "<Authorization>" and "<Token>" with blank or already grouped batchId from "<SheetName>" <RowNumber> to group flattened files and trigger the POST API
    Then a 400 response gets generated to group flattened files
    And an attribute "errors" is verified for grouping flattened files

    Examples: 
      | SheetName | RowNumber | Authorization | Token               |
      | Sheet1    |         0 | Authorization | ic_admin_token      |
      | Sheet1    |         1 | Authorization | ic_technician_token |
      | Sheet1    |         2 | Authorization | hosp_admin_token    |
      | Sheet1    |         3 | Authorization | surgeon_token       |
      | Sheet1    |         4 | Authorization | staff_token         |

  @DUU_PRSAMD-1611_no_data
  Scenario Outline: PRSAMD_1611- Scenario's with Valid Authorization and Invalid batchId
    Given the base URL is entered by the user for grouping of Flattened Files
    When user enters a valid "<Authorization>" and "<Token>" with invalid batchId from "<SheetName>" <RowNumber> to group flattened files and trigger the POST API
    Then a 404 response being generated to group flattened files
    And an attribute "errors" is verified for grouping flattened files

    Examples: 
      | SheetName | RowNumber | Authorization | Token               |
      | Sheet1    |         5 | Authorization | ic_admin_token      |
      | Sheet1    |         6 | Authorization | ic_technician_token |
      | Sheet1    |         7 | Authorization | hosp_admin_token    |
      | Sheet1    |         8 | Authorization | surgeon_token       |
      | Sheet1    |         9 | Authorization | staff_token         |

  @DUU_PRSAMD-1611_unauthorised
  Scenario Outline: PRSAMD_1611- Scenario's with Invalid Authorization and Valid batchId
    Given the base URL is entered by the user for grouping of Flattened Files
    When user enters an invalid "<Authorization>" and "<Token>" with valid batchId to group flattened files and trigger the POST API
    Then a 401 response is getting generated to group flattened files
    And an attribute "errors" is verified for grouping flattened files

    Examples: 
      | Authorization | Token         |
      | Authorization | invalid_token |

  @DUU_PRSAMD-1611_success_Surgeon
  Scenario Outline: PRSAMD_1611- Scenario's with Valid Authorization and Request Body
    Given the base URL is entered by the user for grouping of Flattened Files
    When user enters a valid "<Authorization>" and "<Token>" with valid request body to group flattened files and trigger the POST API
    Then a 200 response is generated to group flattened files
    And an attribute "responseMessage" is verified for grouping flattened files

    Examples: 
      | Authorization | Token         |
      | Authorization | surgeon_token |

  @DUU_PRSAMD-1611_failure_Surgeon
  Scenario Outline: PRSAMD_1611- Scenario's with Valid Authorization and Blank or already grouped batchId
    Given the base URL is entered by the user for grouping of Flattened Files
    When user enters a valid "<Authorization>" and "<Token>" with blank or already grouped batchId from "<SheetName>" <RowNumber> to group flattened files and trigger the POST API
    Then a 400 response gets generated to group flattened files
    And an attribute "errors" is verified for grouping flattened files

    Examples: 
      | SheetName | RowNumber | Authorization | Token         |
      | Sheet1    |         3 | Authorization | surgeon_token |

  @DUU_PRSAMD-1611_Unauthorized_Surgeon
  Scenario Outline: PRSAMD_1611- Scenario's with Invalid Authorization and Valid batchId
    Given the base URL is entered by the user for grouping of Flattened Files
    When user enters an invalid "<Authorization>" and "<Token>" with valid batchId to group flattened files and trigger the POST API
    Then a 401 response is getting generated to group flattened files
    And an attribute "errors" is verified for grouping flattened files

    Examples: 
      | Authorization | Token         |
      | Authorization | invalid_token |
