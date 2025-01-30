import pytest

@pytest.mark.smoke
def test_one():
    print("hello")
    print("hello")
@pytest.mark.smoke
@pytest.mark.xfail
def test_two():
    print("good morning")
@pytest.mark.smoke
@pytest.mark.skip
def test_greet():
    print("good morning")


