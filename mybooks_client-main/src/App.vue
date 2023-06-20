<template>
  <div class="container">
    <h1>Livraria do Vitin</h1>
    <div class="card">
      <nav>
        <ul class="nav nav-pills justify-content-center">
          <li class="nav-item">
            <router-link to="/" class="nav-link btn btn-primary">
              <i class="bi bi-house-fill"></i> Home
            </router-link>
          </li>
          <li class="nav-item">
            <router-link to="/categories/create" class="nav-link btn btn-primary">
              <i class="bi bi-plus-circle-fill"></i> Cadastrar Categoria
            </router-link>
          </li>
          <li class="nav-item">
            <router-link to="/categories" class="nav-link btn btn-primary">
              <i class="bi bi-list-ul"></i> Listar Categoria
            </router-link>
          </li>
          <li class="nav-item">
            <router-link to="/authors/create" class="nav-link btn btn-primary">
              <i class="bi bi-person-plus-fill"></i> Cadastrar Autor
            </router-link>
          </li>
          <li class="nav-item">
            <router-link to="/authors" class="nav-link btn btn-primary">
              <i class="bi bi-people-fill"></i> Listar Autores
            </router-link>
          </li>
        </ul>
      </nav>
    </div>
    <!-- router view to show the component -->
    <router-view></router-view>
  </div>
</template>

<script setup></script>
<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
}

.card {
  max-width: 500px;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.nav-item {
  margin-bottom: 10px;
}

.nav-link {
  color: black;
}
</style>