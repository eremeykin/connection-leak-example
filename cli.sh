#!/bin/bash
source ./common/.env
#curl http://localhost:$SERVER_PORT/song/list?trouble=stream | json_pp
#curl http://localhost:$SERVER_PORT/song/list?trouble=externalInvocation | json_pp
curl http://localhost:$SERVER_PORT/song/list?trouble=rawConnection
