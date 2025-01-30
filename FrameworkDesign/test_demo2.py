import pytest
@pytest.fixture()
def test_three():
    msg = "hi jaya"
    assert msg == "hi","test failed"

def test_four():
    a = 4
    b = 9
    assert a+b == 13, "test passed"

def test_secondgreet():
    print("greeting")