FROM ubuntu:latest
LABEL authors="carli"

ENTRYPOINT ["top", "-b"]