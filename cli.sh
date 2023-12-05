#!/bin/bash
source ./common/.env

curl http://localhost:$SERVER_PORT/song/list?trouble=none
curl http://localhost:$SERVER_PORT/song/list?trouble=externalInvocation
curl http://localhost:$SERVER_PORT/song/list?trouble=rawConnection
curl http://localhost:$SERVER_PORT/song/list?trouble=stream
