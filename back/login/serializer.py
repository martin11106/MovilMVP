from rest_framework import routers, serializers, viewsets

from login.models import login

class loginSerializers(serializers.ModelSerializer):
    class Meta:
        model=login
        fields=('__all__')#visulisar 

