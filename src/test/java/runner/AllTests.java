package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sample.serverest.carts.DeleteCarts;
import sample.serverest.carts.GetCarts;
import sample.serverest.login.PostLogin;
import sample.serverest.products.GetProducts;
import sample.serverest.users.PostUsers;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  GetCarts.class,
  GetProducts.class,
  PostLogin.class,
  DeleteCarts.class,
  PostUsers.class,
})
public class AllTests {}
