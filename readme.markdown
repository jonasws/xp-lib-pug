# xp-lib-pug

Use [Pug](https://pugjs.org/api/getting-started.html) templates with [Enonic XP](http://xp.readthedocs.io/en/stable/)

## Usage

Include the library in your application's `build.gradle`:

```groovy
dependencies {
  ...
  include "me.jonasws.xp:xp-lib-pug:$LATEST_VERSION"
}
```

and then you are free to require the library in your controllers:

```javascript
   var pug = require('/lib/xp/pug')

   var model = {
    // your model key-values
   }

   var view = resolve('your-view-name.pug')

   var body = pug.render(view, model)

```
