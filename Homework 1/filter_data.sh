#!/bin/bash

touch /home/eva/Desktop/Hotel.geojson

echo $(jq '{type: .type, features: [ .features[]| select( .properties.tourism == "hotel") ] }' /home/eva/Desktop/planet.osm.geojson) > /home/eva/Desktop/Hotel.geojson

echo $(jq '{type: .type, features: [ .features[]| select( .properties.website != null) ] }' /home/eva/Desktop/Hotel.geojson) > /home/eva/Desktop/Hotel.geojson

echo $(jq '{type: .type, features: [ .features[]| select( .properties.stars != null) ] }' /home/eva/Desktop/Hotel.geojson) > /home/eva/Desktop/Hotel.geojson

echo $(jq '{type: .type, features: [ .features[]| select( .properties.phone != null) ] }' /home/eva/Desktop/Hotel.geojson) > /home/eva/Desktop/Hotel.geojson

