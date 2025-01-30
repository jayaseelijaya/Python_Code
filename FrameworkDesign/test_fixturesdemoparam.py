import pytest

#setup parameter applicable for all test method
@pytest.mark.usefixtures("dataload")
class Testparamdemo:

    def test_parameter(self,dataload):
        print(dataload[1])

@pytest.mark.usefixtures("multidataload")
class TestMutiparamdemo:

    def test_parameter(self,multidataload):
        print(multidataload[0])
