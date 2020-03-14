from rest_framework import routers, serializers, viewsets

from user.models import user

class userSerializers(serializers.ModelSerializer):
    class Meta:
        model=user
        fields=('__all__')#visulisar 

