import pytest


@pytest.fixture(scope="class")

def setup():
    print("I will be running at first")
    yield
    print("I will be running at last")

#define parameters
@pytest.fixture()

def dataload():
    return ["jaya", "seeli", "Sree"]

@pytest.fixture(params=[("chrome","firefox"),("opera","safari"),("IE","NEW")])

def multidataload(request):
    return request.param
    
    
    
    
    
    
    