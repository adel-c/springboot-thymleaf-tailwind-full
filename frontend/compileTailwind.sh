MY_UID="$(id -u)"
MY_GID="$(id -g)"
dockerImage=tailwind_compiler:1.1
docker inspect ${dockerImage} > /dev/null 2>&1

  # Get the exit code of the command
  exit_code=$?

  if [ $exit_code -eq 0 ]; then
    echo "tailwind_compiler exists"
  else
    echo "tailwind_compiler does not exist"
    docker build -f ./tailwind/Dockerfile . -t ${dockerImage}
  fi

#docker build -f ./src/main/frontend/Dockerfile . -t tailwind_compiler
docker run   -u ${MY_UID}:${MY_GID} -e RUN_WATCH=build -v .:/code ${dockerImage}
