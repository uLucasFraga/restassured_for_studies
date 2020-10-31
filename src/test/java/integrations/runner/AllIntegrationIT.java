package integrations.runner;

import integrations.serverest.carts.DeleteCartsIT;
import integrations.serverest.carts.GetCartsIT;
import integrations.serverest.login.PostLoginIT;
import integrations.serverest.products.GetProductsIT;
import integrations.serverest.products.PostProductsIT;
import integrations.serverest.users.DeleteUsersIT;
import integrations.serverest.users.GetUsersIT;
import integrations.serverest.users.PostUsersIT;
import integrations.serverest.users.PutUsersIT;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  DeleteCartsIT.class,
  GetCartsIT.class,
  PostLoginIT.class,
  GetProductsIT.class,
  PostProductsIT.class,
  DeleteUsersIT.class,
  GetUsersIT.class,
  PostUsersIT.class,
  PutUsersIT.class
})
public class AllIntegrationIT {}
