**Windows (CMD):**
```bat
set BASE_URL=https://jsonplaceholder.typicode.com
set TIMEOUT_MS=15000
mvn -q test
```

**Windows (PowerShell):**
```powershell
$env:BASE_URL="https://jsonplaceholder.typicode.com"
$env:TIMEOUT_MS="15000"
mvn -q test
```

## Lectura del reporte
 
```sh
cat target\surefire-reports\cl.kibernumacademy.test.PostCrudTest.txt
```