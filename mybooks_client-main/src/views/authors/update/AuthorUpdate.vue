<template>
    <div class="author-update">
        <h2>Atualizar Autor</h2>
        <hr>
        <form v-on:submit.prevent="update">
            <input type="text" v-model="author.name">
            <button type="submit">Atualizar</button>
        </form>
        <label for="gender">Gênero:</label>
        <select id="gender" class="form-control" v-model="author.gender">
            <option value="F">F</option>
            <option value="M">M</option>
        </select>
    </div>
</template>
  
<script setup>
import { onMounted, reactive } from "vue"
import axios from "axios";
import baseUrl from '@/api_config.js'
import router from "../../../router";
import { useRoute } from "vue-router";

const route = useRoute()

const author = reactive({
    id: null,
    name: '',
    gender: ''
})

const update = () => {
    axios.put(baseUrl + '/api/author/v1',
        {
            id: author.id,
            name: author.name,
            gender: author.gender

        }
    ).then((response) => {
        alert("Autor Atualizado com Sucesso!")
        router.push("/authors")
    }).catch((error => {
        console.error(error)
    }))
}

onMounted(() => {
    axios.get(baseUrl + '/api/author/v1/' + route.params.id)
        .then((response) => {
            author.id = response.data.id,
                author.name = response.data.name,
                author.gender = response.data.gender
        })
        .catch((error) => {
            alert("Erro ao carregar o autor!")
        })
})

</script>
  
<style lang="scss" scoped>
.author-update {
    margin: 20px;
}

h2 {
    font-size: 24px;
    margin-bottom: 10px;
}

form {
    margin-top: 10px;
}

input[type="text"] {
    width: 200px;
    padding: 5px;
    border: 1px solid #ccc;
}

button[type="submit"] {
    margin-top: 10px;
    padding: 5px 10px;
    background-color: #007bff;
    color: #fff;
    border: none;
    cursor: pointer;
}

button[type="submit"]:hover {
    background-color: #0069d9;
}

button {
    margin-top: 10px;
    padding: 5px 10px;
    background-color: #dc3545;
    color: #fff;
    border: none;
    cursor: pointer;
}

button:hover {
    background-color: #c82333;
}
</style>