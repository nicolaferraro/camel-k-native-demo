# Camel K + Knative Demo

This demo shows how some examples of Camel K and Knative working together.

## Requirements:
- An openshift/kubernetes cluster
- Knative Serving and Eventing
- Camel K kamel

## Setup:

Install Camel K on the current namespace:

```
kamel install
``` 

You need cluster-admin permissions when running it for the first time on the cluster.

## Serving Example

This example shows how to call a quarkus function from Camel K.

Deploy the quarkus function using:

```
cd serving
kubectl apply quarkus.yaml
```

You can change the code and rebuild the docker container if needed.

Deploy the Camel K caller using:

```
kamel run caller.groovy
```

The Quarkus service should print some logs.
If you stop the camel k caller:

```
kamel delete caller
``` 

Then the quarkus pod will be scaled down.


## Eventing Example

The eventing example shows how to pass messages to downstream services using channels.

First, create a channel:

```
cd eventing
kubectl apply messages-channel.yaml 
```

Then deploy the importer:

```
kamel run importer.groovy
```

And the printer:

```
kamel run Printer.java
```

The printer pod will show some funny jokes.

If you stop the importer:

```
kamel delete the importer
```

Then the printer will be scaled down.