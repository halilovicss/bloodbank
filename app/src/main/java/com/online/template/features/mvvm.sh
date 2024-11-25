#!/bin/bash

# Provera da li je unet početni direktorijum
if [ -z "$1" ]; then
  echo "Molim te unesi putanju do početnog direktorijuma kao argument."
  exit 1
fi

BASE_DIR="$1"

# Kreiranje osnovnih direktorijuma
mkdir -p "$BASE_DIR/data/local/daos"
mkdir -p "$BASE_DIR/data/local/data_sources"
mkdir -p "$BASE_DIR/data/local/mappers"
mkdir -p "$BASE_DIR/data/local/models"
mkdir -p "$BASE_DIR/data/remote/data_sources"
mkdir -p "$BASE_DIR/data/remote/mappers"
mkdir -p "$BASE_DIR/data/remote/models"
mkdir -p "$BASE_DIR/data/remote/services"
mkdir -p "$BASE_DIR/data/repositories"
mkdir -p "$BASE_DIR/data/type_converter"
mkdir -p "$BASE_DIR/di"
mkdir -p "$BASE_DIR/domain/use_case"
mkdir -p "$BASE_DIR/domain/enums"
mkdir -p "$BASE_DIR/domain/abstraction"
mkdir -p "$BASE_DIR/domain/entities"
mkdir -p "$BASE_DIR/presentation/adapter"

echo "Struktura direktorijuma za MVVM arhitekturu je uspešno kreirana."