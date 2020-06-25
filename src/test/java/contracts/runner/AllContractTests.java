package integrations.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import integrations.serverest.carts.DeleteCarts;
import integrations.serverest.carts.GetCarts;
import integrations.serverest.login.PostLogin;
import integrations.serverest.products.GetProducts;
import integrations.serverest.users.PostUsers;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  GetCarts.class,
  GetProducts.class,
  PostLogin.class,
  DeleteCarts.class,
  PostUsers.class,
})
public class AllIntegrationTests {}
