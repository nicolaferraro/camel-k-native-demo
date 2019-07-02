
from('timer:tick?period=15s')
  .to("http4://api.icndb.com/jokes/random")
  .to('knative:channel/messages')


