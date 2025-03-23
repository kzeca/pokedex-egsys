<h1 align="center">Android Pokedex</h1>

<p align="center">
  <a href="https://devlibrary.withgoogle.com/products/android/repos/skydoves-pokedex"><img alt="Google" src="https://skydoves.github.io/badges/google-devlib.svg"/></a><br>
  <a href="https://opensource.org/licenses/MIT"><img alt="License" src="https://img.shields.io/badge/License-MIT License-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=16"><img alt="API" src="https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://github.com/kzeca"><img alt="Profile" src="https://img.shields.io/badge/Profile-kzeca-red"/></a> 
</p>

<p align="center">  
Pokedex is a Native Android application developed for knowledge assessment. This <a href="https://kotlinlang.org/">Kotlin</a> project demonstrates modern development techniques such as Jetpack Components (ViewModel, LiveData, Navigation), Retrofit, Espresso, Animations, and other methods based on the MVVM architecture.
</p>
<p>In summary, it's an application that lists Pokemon using https://pokeapi.co/, filters them by type, and searches through the extensive database. Additionally, there's a feature to randomly select a Pokemon and display its basic information such as Type, Name, Weight, Height, and its "Listing Number". If you click on one of the Pokemon in the home list, its details will appear on another screen. It's quite fun :)</p>
</br>

<p align="center">
<img src="./assets/pokedexLogoReame.png"/>
</p>

## Download
Go to [Releases](https://github.com/skydoves/Pokedex/releases) and download the latest available APK.

<img src="./assets/screenShootSplash.jpg" align="right" width="30%"/>

## Applied Stack & Open-source Libraries
- Minimum SDK level 16
- [Kotlin](https://kotlinlang.org/) based
- Jetpack
  - Lifecycle: Adds an observer to the Android lifecycle and has functions to handle UI changes in this cycle.
  - ViewModel: Controls data holders and changes that the Lifecycle notices. Allows data to persist when configuration changes occur (e.g., screen rotation).
  - Navigation: Navigation between fragments and activities.
- Architecture
  - MVVM (View - ViewModel - Model)
- Repository
    - [Retrofit2](https://github.com/square/retrofit): Building REST APIs.
- [Glide](https://github.com/bumptech/glide), [GlidePalette](https://github.com/florent37/GlidePalette): Loading images from the web
- Tests
    - [Espresso](https://developer.android.com/training/testing/espresso): Library for integration tests

## Screen Samples
<img src="./assets/screenShootHome.jpg" width="30%"/>
<img src="./assets/screenShootDetails.jpg" width="30%"/>
<img src="./assets/screenShootDarkMode.jpg" width="30%"/>
<p>(yes, we even have dark theme)</p>
<p>If you want to access the screen prototyping, just click <a href="https://www.figma.com/file/sQDa5ZRhr7NfeIIeBBuw1A/Pokedex?node-id=29%3A4">here</a>

## Diagrams
- Use Case: 
![useCase](./assets/userCaseDiagram.png)
<br>
  - Activity: <a href="https://drive.google.com/file/d/1ZvfoPvWFJKk12Gt8XKiEaiKoV7kpDnta/view?usp=sharing">Link</a>

## Architecture
Pokedex-egsys is based on the MVVM architecture. It follows the pattern:

![architecture](./assets/MVVM.png)

## Open API

<img src="https://user-images.githubusercontent.com/24237865/83422649-d1b1d980-a464-11ea-8c91-a24fdf89cd6b.png" align="right" width="21%"/>

Pokedex-egsys uses the [PokeAPI](https://pokeapi.co/) to build RESTful API.<br>
PokeAPI provides an interface with extremely well-detailed objects to be built with Pokemon of all ways, types, and forms.

# Test it yourself

## Requirements
- Android Studio
- Git
- Contentful CLI
- Android build tools
- An Android phone 5.0 and up
## Downloading the project

```bash
# Clone this repository
$ git clone https://github.com/kzeca/pokedex-egsys.git
```
### Note: Project KDoc documentation is in the documentation folder. There you will find more information related to how the project works

<br>
<br>

# License
```xml
MIT License

Copyright (c) 2022 José Carlos Peixoto Leão

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
