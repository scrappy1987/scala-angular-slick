import com.google.inject.{Guice, AbstractModule}
import play.api.GlobalSettings
import dao.{Dao,AbstractDao}

/**
 * Created by John1 on 06/11/2015.
 */
object Global extends GlobalSettings {

  val injector = Guice.createInjector(new AbstractModule {
    protected def configure() {
      bind(classOf[AbstractDao]).to(classOf[Dao])
    }
  })

  /**
   * Controllers must be resolved through the application context. There is a special method of GlobalSettings
   * that we can override to resolve a given controller. This resolution is required by the Play router.
   */
  override def getControllerInstance[A](controllerClass: Class[A]): A = injector.getInstance(controllerClass)
}
