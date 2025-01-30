import pytest

#setup parameter applicable for all test method
@pytest.mark.usefixtures("setup")
class Testfixturedemo:

    def test_three(setup):
        msg = "hi jaya"
        assert msg == "hi","test failed"

    def test_four(setup):
        a = 4
        b = 9
        assert a+b == 13, "test passed"

    def test_secondgreet(setup):
        print("greeting")