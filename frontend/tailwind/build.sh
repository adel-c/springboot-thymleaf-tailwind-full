cd /code/tailwind
npm i

if [ "$RUN_WATCH" == "watch" ]; then
  npx tailwindcss -i /code/${FRONT_DIRECTORY}/src/main/resources/static/main.css -o /code/${FRONT_DIRECTORY}/target/classes/static/main.css --watch
else
   npx tailwindcss -i /code/${FRONT_DIRECTORY}/src/main/resources/static/main.css -o /code/${FRONT_DIRECTORY}/target/classes/static/main.css
fi
