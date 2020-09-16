package integrations.runner;

import integrations.serverest.carts.DeleteCartsIT;
import integrations.serverest.carts.GetCartsIT;
import integrations.serverest.login.PostLoginIT;
import integrations.serverest.products.GetProductsIT;
import integrations.serverest.users.GetUsersIT;
import integrations.serverest.users.PostUsersIT;
import integrations.serverest.users.PutUsersIT;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  GetUsersIT.class,
  GetCartsIT.class,
  GetProductsIT.class,
  DeleteCartsIT.class,
  PostLoginIT.class,
  PostUsersIT.class,
  PutUsersIT.class
})
public class AllIntegrationIT {}
