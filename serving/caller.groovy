
from('timer:tick?period=5s')
  .setBody().constant("Hello quarkus")
  .to('knative:endpoint/quarkus')
