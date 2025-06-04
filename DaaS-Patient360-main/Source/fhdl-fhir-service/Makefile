all: build login tag push

name = fhdl-fhir-service
repo = $(registry)/$(repopath)

build:
	@echo "Build docker image"
	docker build \
	--build-arg PROXY=$(proxy) \
	--build-arg SECURE_PROXY=$(secure_proxy) \
	--build-arg JARVERSION=$(jarversion) \
	-t $(repo)/$(name):$(version) ./
	
login:
	@echo "Login to docker repo"

tag:
	@echo "Create tag for docker image"
	docker tag $(repo)/$(name):$(version) $(repo)/$(name):$(version)

push:
	@echo "Push docker image to registry"
	docker push $(repo)/$(name):$(version)
	