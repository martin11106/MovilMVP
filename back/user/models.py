from django.db import models
from django.utils import timezone

class user(models.Model):
    Nombre=models.CharField(max_length=254,null=False)
    apellido=models.CharField(max_length=254,null=False)
    edad=models.IntegerField(null=False)
    sexo=models.CharField(max_length=254,null=False)
    direccion=models.CharField(max_length=254,null=False)
    carrera=models.CharField(max_length=254,null=False)

# Create your models here.
