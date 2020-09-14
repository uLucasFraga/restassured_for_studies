package integrations.runner;

import integrations.serverest.carts.DeleteCartsIT;
import integrations.serverest.carts.GetCartsIT;
import integrations.serverest.login.PostLoginIT;
import integrations.serverest.products.GetProductsIT;
import integrations.serverest.users.PostUsersIT;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  GetCartsIT.class,
  GetProductsIT.class,
  PostLoginIT.class,
  DeleteCartsIT.class,
  PostUsersIT.class,
})
public class AllIntegrationIT {}
