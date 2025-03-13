cd /code/tailwind
npm i

if [ "$RUN_WATCH" == "watch" ]; then
  npx @tailwindcss/cli -i /code/${FRONT_DIRECTORY}/tailwind/base.css -o /code/${FRONT_DIRECTORY}/target/classes/static/main.css --watch
else
   npx @tailwindcss/cli -i /code/${FRONT_DIRECTORY}/tailwind/base.css -o /code/${FRONT_DIRECTORY}/target/classes/static/main.css
fi
