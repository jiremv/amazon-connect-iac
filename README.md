
# Amazon Connect Contact Center IaC con AWS SAM y Java

Este proyecto despliega una solución serverless básica para Amazon Connect utilizando **AWS SAM**, **Java 21 con Quarkus**, y **Moshi** como biblioteca de serialización JSON. Incluye una función Lambda expuesta mediante API Gateway y la creación de una instancia de Amazon Connect con su configuración básica.

## 🧩 Componentes Incluidos

- **Amazon Connect Instance**
- Horarios de operación (`HoursOfOperation`)
- Cola principal (`Queue`)
- API Gateway REST
- Lambda Java con handler `GreetingHandler`
- Permisos e integraciones necesarias

---

## 🚀 Endpoints REST

| Método | Ruta            | Descripción                       |
|--------|------------------|------------------------------------|
| POST   | `/connect`       | Llama al Lambda `GreetingFunction` |
| OPTIONS | `/connect`      | Soporte para CORS                  |

---

## ⚙️ Tecnologías Utilizadas

- **AWS SAM (Serverless Application Model)**
- **Java 21** con **Quarkus**
- **Moshi** para JSON
- **Amazon Connect**
- **API Gateway**
- **GitHub Actions** para CI/CD

---

## 🔄 CI/CD con GitHub Actions

El proyecto incluye **dos pipelines automáticos** definidos en `.github/workflows/`:

### 🔧 `deploy-dev.yml`

- Se activa al hacer `push` a la rama `dev`
- Despliega a la región `us-east-1` usando el bucket y roles configurados
- Usa los secretos `AWS_ACCESS_KEY_ID` y `AWS_SECRET_ACCESS_KEY` para autenticarse

### 🚀 `deploy-prod.yml`

- Se activa al hacer `push` a la rama `main`
- Despliega automáticamente a `us-east-2`
- Utiliza el bucket `prod-artifacts-bucket-s3`
- No requiere intervención manual

Ambos pipelines ejecutan:

```bash
sam build
sam deploy ...
```

Y utilizan secrets del repositorio configurados en GitHub (Settings → Secrets → Actions).

---

## 📝 Cómo usar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tuusuario/amazon-connect-iac.git
   ```

2. Compila el proyecto:
   ```bash
   mvn clean package
   ```

3. Ejecuta localmente con SAM (opcional):
   ```bash
   sam local invoke
   ```

4. Haz `git push origin main` o `dev` y GitHub Actions se encargará del despliegue.

---

## 📦 Estructura

```
.
├── template-connect.yaml           # Infraestructura SAM
├── src/
│   └── main/java/com/connect/GreetingHandler.java
├── .github/workflows/
│   ├── deploy-dev.yml
│   └── deploy-prod.yml
└── README.md
```

---

## 👨‍💼 Autor

**Paul Rivera**
- AWS Certified Solutions Architect - Associate

---
