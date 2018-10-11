# Genestack tutorial with @genestack/system-api (unofficial)

This tutorial briefly describes how to deal with new modularized 
[JS API](https://www.npmjs.com/package/@genestack/system-api). The main idea of applications
remains the same as it described in 
[official Genestack tutorial](https://genestack.com/developers/tutorials.html#calling-java-methods-from-javascript).
The basic difference is that now it is considered that you manage js dependencies with
[NPM](https://www.npmjs.com/) and build UI of your application with some kind of frontend builder,
e.g. [webpack](https://webpack.js.org/), [rollup](https://webpack.js.org/), 
[browserify](http://browserify.org/) or whatever you like that supports CommonJS modules 
(this particular tutorial is made with Webpack).

## Preconditions
You need NPM and Node.js installed on your computer. Download Node 
[from its official site](https://nodejs.org/en/), or install it with 
[your package manager](https://nodejs.org/en/download/package-manager/). NPM is installed with Node
by default

## Dependencies
In this tutorial all basic dependencies are already listed in `package.json`. So go to 
`src/main/js` and run `npm install` to install all js dependencies. 

## JavaScript
The main JS file now located in `src/main/js/index.js`. In this tutorial we don't use ES6, JSX, 
TypeScript or any other advanced frontend modes. The script is used 
[CommonJS](https://github.com/webpack/docs/wiki/commonjs) standard for dependency loading. 
You could load dependencies declared in `package.json` with 
```js
var foo = require('foo');
```
and your local dependencies with relative path:
```js
var bar = require('./bar');
```
assuming, that `./bar.js` declare its exports as: 
```js
module.exports = function whatever() { /* ... or any other object */ }
```

## Build
Before you package your Maven module, run (in `src/main/js/`) 
```
npm run build
```
it will execute a script from `package.json`, which is:
```json
"build": "webpack index.js --output ../resources/assets/bundle.js --mode production"
```
This will, in turn, bundle your js and put it into `src/resorurces/assets` folder as `bundle.js`.
This file is set in resources section of `applications.xml` (note that it is also listed in 
`.gitignore`, because it is an artifact of build and should not be a subject of version control).
