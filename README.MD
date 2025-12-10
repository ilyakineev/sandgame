# Инструкция по запуску проекта

## Требования

Перед запуском убедитесь, что у вас установлено:

* **Java 17+**
* **Gradle**
* **Git**
* Проект склонирован локально

---

## 📂 1. Клонирование репозитория

```bash
git clone https://github.com/ilyakineev/sandgame.git
cd sandgame
```

---

## ⚙️ 2. Локальный запуск через Gradle

Находясь в корневой папке `sandgame`, выполните:

### **Linux/macOS**

```bash
./gradlew bootRun
```

### **Windows**

```bash
gradlew.bat bootRun
```

После запуска приложение будет доступно по адресу:

👉 [http://localhost:8080](http://localhost:8080)

---

# 🐳 3. Сборка Docker-образов (ARM и x86)

Сначала необходимо собрать JAR-файл в production-режиме:

```bash
./gradlew clean bootJar -Pvaadin.productionMode
```

---

## Сборка Docker-образов

### **ARM (обычно Mac M1/M2/M3, Raspberry Pi и т.п.)**

```bash
docker build -t sandgame_image_arm .
```

### **x86 (обычно Linux/Windows серверы, большинство облаков)**

```bash
docker buildx build --platform linux/amd64 -t sandgame_image_x86 .
```

---

## Запуск контейнеров

### **ARM**

```bash
docker run --rm -p 8080:8080 --name sandgame sandgame_image_arm
```

### **x86**

```bash
docker run --rm -p 8080:8080 --name sandgame sandgame_image_x86
```

После запуска приложение будет доступно по адресу:

👉 [http://localhost:8080](http://localhost:8080)

---

# 📦 4. Экспорт и передача Docker-образов

### **Сохранение ARM-образа**

```bash
docker save -o sandgame_image_arm.tar sandgame_image_arm
```

### **Сохранение x86-образа**

```bash
docker save -o sandgame_image_x86.tar sandgame_image_x86
```

---

## 5. Импорт получателем

### **ARM**

```bash
docker load -i sandgame_image_arm.tar
```

### **x86**

```bash
docker load -i sandgame_image_x86.tar
```

---

## 6. Запуск импортированных образов

### **ARM**

```bash
docker run -d -p 8080:8080 --name sandgame sandgame_image_arm
```

### **x86**

```bash
docker run -d -p 8080:8080 --name sandgame sandgame_image_x86
```