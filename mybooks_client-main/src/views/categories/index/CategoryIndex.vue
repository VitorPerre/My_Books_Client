<template>
  <div>
    <h1>Categorias</h1>
    <div>
      <table class="table table-striped">
        <tr>
          <th>Id</th>
          <th>Nome</th>
          <th>Comandos</th>
        </tr>
        <tbody>
          <tr v-for="category in categories" :key="category.id">
            <td>{{ category.id }}</td>
            <td>{{ category.name }}</td>
            <td>
              <router-link :to="{ name: 'categories-update', params: { id: category.id } }" class="btn btn-primary">Editar</router-link>
              <button @click="deleteCategory(category.id)" class="btn btn-danger">Excluir</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup>
import axios from 'axios'
import baseUrl from '@/api_config.js'
import { onMounted, ref } from 'vue'
import { useRouter } from 'vue-router'

const categories = ref()
const router = useRouter()

// Function to get all categories from the API
const getAll = () => {
  axios
    .get(baseUrl + '/api/category/v1')
    .then(response => {
      categories.value = response.data._embedded.categories
    })
    .catch(error => {
      console.error('Erro: ', error)
    })
}

// Lifecycle hook: what will be done when the component is rendered
onMounted(() => {
  getAll()
})

// Function to delete a category
const deleteCategory = categoryId => {
  axios
    .delete(baseUrl + '/api/category/v1/' + categoryId)
    .then(response => {
      alert('Categoria excluída com sucesso!')
      getAll() // Refresh the category list after deletion
    })
    .catch(error => {
      console.error(error)
    })
}
</script>

<style scoped></style>