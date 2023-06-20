<template>
    <div class="container">
        <div class="card">
            <h2>Cadastrar Novo Autor</h2>
            <hr>
            <form v-on:submit.prevent="create">
                <div class="form-group">
                    <label for="name">Nome:</label>
                    <input type="text" id="name" class="form-control" v-model="name">
                </div>
                <div class="form-group">
                    <label for="gender">Gênero:</label>
                    <select id="gender" class="form-control" v-model="gender">
                        <option value="M">M</option>
                        <option value="F">F</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </div>
    </div>
</template>
  
<script setup>
import { ref } from "vue"
import axios from "axios"
import baseUrl from "@/api_config.js"
import router from "../../../router"

const name = ref("")
const gender = ref("")

const create = () => {
    axios
        .post(baseUrl + "/api/author/v1", {
            name: name.value,
            gender: gender.value
        })
        .then((response) => {
            alert("Autor Cadastrado com Sucesso!")
            router.push("/authors")
        })
        .catch((error) => {
            alert("Erro: " + error)
        })
}
</script>
  
<style scoped>
.container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.card {
    max-width: 400px;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.form-group {
    margin-bottom: 15px;
}

.btn-primary {
    width: 100%;
}
</style>
  