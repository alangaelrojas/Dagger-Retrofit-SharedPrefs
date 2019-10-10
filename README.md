# Dagger-Retrofit-SharedPrefs
App to use dependencies injection with Dagger2 with components and sub components.

**Project Structure**

**adapter**
TiempoAdapter
**api**
ApiClient
  **di**
  **component**
ApplicationComponent
 MensajeComponent
 SharedPreferencesSubComponent
**module**
 AdapterModule
 ApplicationContextModule
MensajeModule
RetrofitModule
 SharedPreferencesModule
**scope**
ApplicationScope
MensajeScope
SharedPreferencesScope
**base application**


# Analysis Dagger2


## ADAPTER


## API



## DI - Dagger Injection

### MODULE
#### anotacion @Module
Los módulos son un elemento básico para trabajar con Dagger, se coloca la anotación @Modulo, una linea arriba de nuestro public class, como se muestra continuación:

    @Module  
    public class AdapterModule {  
      
    }
Los módulos nos sirven para contener los métodos que van a contener los métodos que serán inyectados en nuestra aplicación. Cada método necesita ademas de la anotación @Provides, como se ve en el siguiente codigo: 

    @Module  
    public class AdapterModule { 
      
	    @Provides  
	    public TiempoAdapter getTiempoAdapter(){  
            return new TiempoAdapter();  
		}  
    }

en este ejemplo, se muestra como este método devuelve un objeto de tipo TiempoAdapter, que devuelve el adaptador que usaremos para nuestro recyclerView en la instrucción *recyclerview.setAdapter(adapter)*, aquí podemos ver como tenemos el adaptador de forma desacoplada a nuestro activity. Por regla, los métodos proveedores no pueden ser privados.

### COMPONENT
#### anotacion @Component
La anotacion @Component le indica a Dagger que esta interfaz contiene las clases donde se inyectaran las dependencias, como en el siguiente ejemplo:

    @Component(modules = {ApplicationContextModule.class, RetrofitModule.class, AdapterModule.class})  
    public interface ApplicationComponent {  
        void inject(SecondActivity secondActivity);  
    }
En este ejemplo podemos ver como con la linea 
**void inject(SecondActivity secondActivity); ** estamos definiendo que el método solo sera util cuando sea inyectado en el activity que sea declarado, en este caso SecondActivity.

Es importante saber que los componentes dependen de los módulos, eso quiere decir que un componente esta compuesto, ademas de los métodos que definen el activity o fragment donde deben ser inyectados, también los módulos que depende de este componente, como podemos ver 
**@Component(modules = {ApplicationContextModule.class, RetrofitModule.class, AdapterModule.class}) **, en este ejemplo vemos como esta declarando 3 módulos, como vemos podemos declarar uno o mas módulos.

### SCOPE 
#### anotacion @Scope
En Dagger, el mecanismos de scopes se preocupa por mantener su inica instancia de clase mientras exista su alcance.

Ejemplo: @ApplicationScope tiene una vida tan larga como el objecto application, es decir, durante toda la vida de la aplicación.

@ActivityScope tiene una vida mientras dura el activity, esto tiene decir que se puede compartir una instancia única de cualquier clase entre los diferentes fragment de la activity, hasta que esta sea destruida.
