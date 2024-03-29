// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

function showFunFacts(){
    const facts = 
        ['I play soccer', 'I was on TV for a minute on Telemundo', 'Tacos are my favorite food',
        'I love going on hikes', 'I love learning about cooking and investing'];
    const fact = facts[Math.floor(Math.random() * facts.length)];
    const factContainer = document.getElementById('greeting-container');
    factContainer.innerText = fact;
}

async function showPlaces() {
    const responseFromServer = await fetch('/hello');
    const jsonData = await responseFromServer.json();

    const placeText = jsonData[Math.floor(Math.random()*jsonData.length)];

    const responseContainer = document.getElementById('response-container');
    responseContainer.innerText = placeText;
}
