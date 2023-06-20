<template>
    <div>
        <h1>Autores</h1>
        <div class="table-container">
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>Sexo |</th>
                    <th>Comandos</th>
                </tr>
                <tbody>
                    <tr v-for="author in authors" :key="author.id">
                        <td>{{ author.id }}</td>
                        <td>{{ author.name }}</td>
                        <td>{{ author.gender }}</td>
                        <td>
                            <router-link :to="{ name: 'authors-update', params: { id: author.id } }" class="btn btn-primary text-white">
                                Editar
                            </router-link>
                            <button @click="deleteAuthor(author.id)" class="btn btn-danger text-white">
                                Excluir
                            </button>
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

const route = useRouter()

const authors = ref([])

// Function to get all authors from the API
const getAll = () => {
    axios
        .get(baseUrl + '/api/author/v1')
        .then(response => {
            authors.value = response.data
        })
        .catch(error => {
            console.error('Erro: ', error)
        })
}

// Lifecycle hook: what will be done when the component is rendered
onMounted(() => {
    getAll()
})

// Function to delete an author
const deleteAuthor = authorId => {
    axios
        .delete(baseUrl + '/api/author/v1/' + authorId)
        .then(response => {
            alert('Autor excluído com sucesso!')
            getAll() // Refresh the author list after deletion
        })
        .catch(error => {
            console.error(error)
        })
}
</script>
  
<style scoped>
.table-container {
    max-height: 400px;
    overflow-y: auto;
}
</style>
  